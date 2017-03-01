package com.yagout.defense.biz.impl;

import com.yagout.defense.biz.AlarmBiz;
import com.yagout.defense.biz.DictionaryBiz;
import com.yagout.defense.biz.bean.SoketBean;
import com.yagout.defense.dal.model.Dictionary;
import com.yagout.defense.dal.model.StrategyKey;
import com.yagout.defense.service.*;
import com.yagout.defense.util.*;
import org.apache.log4j.Logger;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

@Service
public class AlarmBizImpl implements AlarmBiz {
	private static Logger logger = Logger.getLogger(AlarmBizImpl.class);
	@Autowired
	private AlarmService service;

	@Autowired private UserLogService userLogService;
	
	@Autowired
	private ScanApService apService;

	@Autowired private ScanStationService scanStationService;
	
	@Autowired private DictionaryBiz dictionaryBiz;

    @Value("${docTempPath}")
	private  String filePath;
	@Autowired
	private SokectSendService sokectSendService;
	
	@Override
	public void report(ModelAndView view) {
		try{
			view.addObject("apRiskEnum",ApRiskEnum.MAX_RISK);
	        view.addAllObjects(getReportMap());
	        this.userLogService.insertUserLog(LogTypeEnum.TYPE_CREATE_REPORT, true, "");
		}
		catch (Exception e) {
			// TODO: handle exception
			this.userLogService.insertUserLog(LogTypeEnum.TYPE_CREATE_REPORT, false, "生成安全报告异常！");
		}
	}


	@Override
	public byte[] reportDown( ) throws Exception{
		File isExist = new File(filePath);
		/**判断源文件是否存在*/
		if(!isExist.exists()){
			throw  new  Exception("doc文件不存在");
		}
        Map<String,Object>  dataMap= getReportMap();
		XWPFDocument document;
		InputStream is;
        is = new FileInputStream(filePath);
		document = new XWPFDocument(is);
		/**取得文本的所有表格*/
		Iterator<XWPFTable> it = document.getTablesIterator();
        ReportEnum reportEnum=null;
        String cellText;
		while(it.hasNext()){/**循环操作表格*/
			XWPFTable table = it.next();
			List<XWPFTableRow> rows = table.getRows();
			for(XWPFTableRow row:rows){
                /**取得表格的行*/
				List<XWPFTableCell> cells = row.getTableCells();
				for(XWPFTableCell cell:cells){
                    cellText=cell.getText();
                    if(cellText.indexOf("{")>0&&cellText.indexOf("}")>0){
                        /**取得单元格*/
                        reportEnum=ReportEnum.find(cellText.substring(cellText.indexOf("{")+1,cellText.indexOf("}")));
                        if (reportEnum!=null){
                            cellEdit(cell,reportEnum,dataMap,document);
                        }
                        if(reportEnum.equals(ReportEnum.CHANNLE)||reportEnum.equals(ReportEnum.RISK)){
							break;//循环中动态修改 table后会报错
						}
                    }else {
                        reportEnum=null;
                    }
				}
				if(reportEnum!=null&&(reportEnum.equals(ReportEnum.CHANNLE)||reportEnum.equals(ReportEnum.RISK))){
					break;//循环中动态修改 table后会报错
				}
			}
		}
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		document.write(outputStream);
		is.close();
		outputStream.close();
		return outputStream.toByteArray();
	}

	//处理单元格
	private void  cellEdit(XWPFTableCell cell,   ReportEnum reportEnum,  Map<String,Object>  dataMap,XWPFDocument doc)throws Exception{
        switch (reportEnum){
            case TAP_SIZE:

            case SAVEAP_SIZE:

            case SAVEAP_SHOW:

            case STATION_SIZE:
                //替换单元格内容
                processParagraphs(cell.getParagraphs(),dataMap);
                break;
            case CHANNLE:

                channleTable((Map<Integer,Object> )dataMap.get(ReportEnum.CHANNLE.getCode()),cell);
                break;
            case RISK:

                riskTable((Map<Integer,Set<Map<String,Object>>> )dataMap.get(ReportEnum.RISK.getCode()),cell);
                break;
        }
    }
    private  void  riskTable(Map<Integer,Set<Map<String,Object>>>  riskMap,XWPFTableCell cell)throws Exception{
        int index=0;
        XWPFTableRow  addRow=cell.getTableRow();
        XWPFTableCell tmpCell=addRow.getCell(0);
        ApRiskEnum apRiskEnum;//风险类型
        if(riskMap!=null){
            for (Map.Entry<Integer,Set<Map<String,Object>>> entry: riskMap.entrySet()){
                apRiskEnum=ApRiskEnum.find(entry.getKey());
                  for(Map<String,Object> apEntry: entry.getValue()){
                      if(index!=0){
                          addRow=  addRow.getTable().createRow();
                          setCellText(tmpCell, addRow.getCell(0),apRiskEnum.getMsg());
                          setCellText(tmpCell, addRow.getCell(1),(String)apEntry.get("ssid"));
                          setCellText(tmpCell, addRow.getCell(2),(String)apEntry.get("mac"));
                          setCellText(tmpCell, addRow.getCell(3),(String) apEntry.get("maker"));
                          setCellText(tmpCell, addRow.getCell(4),(Integer) apEntry.get("channel")+"");
                          setCellText(tmpCell, addRow.getCell(5),(Integer) apEntry.get("signal")+"");
                          setCellText(tmpCell, addRow.getCell(6),(String) apEntry.get("privacy")+"");
                          setCellText(tmpCell, addRow.getCell(7),(String) apEntry.get("encryptWay")+"");
                          setCellText(tmpCell, addRow.getCell(8),(String) apEntry.get("wps")+"");
                          setCellText(tmpCell, addRow.getCell(9),(String) apEntry.get("broadcastSsid")+"");
                          setCellText(tmpCell, addRow.getCell(10),apRiskEnum.getAdvice());
                      }else {
                          processParagraphs(addRow.getCell(0).getParagraphs(),ReportEnum.RISK.getCode(),apRiskEnum.getMsg());
                           addRow.getCell(1).setText((String)apEntry.get("ssid"));
                           addRow.getCell(2).setText((String)apEntry.get("mac"));
                           addRow.getCell(3).setText((String) apEntry.get("maker"));
                           addRow.getCell(4).setText((Integer) apEntry.get("channel")+"");
                           addRow.getCell(5).setText((Integer) apEntry.get("signal")+"");
                          addRow.getCell(6).setText((String) apEntry.get("privacy"));
                          addRow.getCell(7).setText((String) apEntry.get("encryptWay"));
                          addRow.getCell(8).setText((String) apEntry.get("wps"));
                          addRow.getCell(9).setText((String) apEntry.get("broadcastSsid"));
                          addRow.getCell(10).setText(apRiskEnum.getAdvice());
                      }
                      index++;
                  }

            }


        }
    }

     //信道表格 rowspan 前面两个单元格要跨行
      private  void  channleTable(Map<Integer,Object>  channelMap,XWPFTableCell cell)throws Exception{
         if(channelMap!=null){
             XWPFTableCell rowSpanCell;
             XWPFTableCell rowSpanCell2;
             int toRow;
             Map<Integer,Integer> index= channleAddRow(channelMap,cell.getTableRow());
             for (Map.Entry<Integer,Integer> entry:index.entrySet()){
                 toRow=entry.getKey()+entry.getValue()+1 ;
                 if(entry.getValue()>1){
                     for( int rowIndex=entry.getKey()+1 ;rowIndex<toRow;rowIndex++){
                         rowSpanCell=cell.getTableRow().getTable().getRow(rowIndex).getCell(0);
                         rowSpanCell2=cell.getTableRow().getTable().getRow(rowIndex).getCell(1);
                         if (rowIndex==entry.getKey()+1 ) {
                             rowSpanCell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);//重新开始
                             rowSpanCell2.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);//重新开始
                         } else {
                             rowSpanCell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);//合并
                             rowSpanCell2.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);//合并
                         }

                     }
                 }

             }
         }
      }

     //拼装信道的表格
      private  Map<Integer,Integer>  channleAddRow(Map<Integer,Object>  channelMap,XWPFTableRow tableRow) throws Exception{
          Map<Integer,Integer>  integerMap=new HashMap<Integer, Integer>();
          int index=0;
		  Set<Map<String, Object> > apSet;
          XWPFTableRow  addRow=tableRow;
          XWPFTableCell tmpCell=tableRow.getCell(0);
          for (Map.Entry<Integer,Object> entry: channelMap.entrySet()){
			  apSet=(Set<Map<String, Object> >)entry.getValue();
               if(apSet!=null){
                   integerMap.put(index,apSet.size());
                   for (Map<String, Object>  apEntry:apSet){
                       if(index!=0){
						   addRow=  addRow.getTable().createRow();
						   //替换单元格内容
                           setCellText(tmpCell, addRow.getCell(0),entry.getKey()+"");
                           setCellText(tmpCell, addRow.getCell(1),apSet.size()+"");//ap总条数
                           setCellText(tmpCell, addRow.getCell(2),(String)apEntry.get("ssid"));
                           setCellText(tmpCell, addRow.getCell(3),(String) apEntry.get("mac"));
                       }else {

						   processParagraphs(addRow.getCell(0).getParagraphs(),ReportEnum.CHANNLE.getCode(),entry.getKey()+"");
                           addRow.getCell(1).setText(apSet.size()+"");//ap总条数
                           addRow.getCell(2).setText((String)apEntry.get("ssid"));
                           addRow.getCell(3).setText((String) apEntry.get("mac"));
					   }
                       index++;
                   }

               }
           }
                 return  integerMap;
      }

    //复制表格样式
    public  void setCellText(XWPFTableCell tmpCell,XWPFTableCell cell,String text) throws Exception{
        CTTc cttc2 = tmpCell.getCTTc();
        CTTcPr ctPr2=cttc2.getTcPr();

        CTTc cttc = cell.getCTTc();
        CTTcPr ctPr = cttc.addNewTcPr();
        cell.setColor(tmpCell.getColor());
        cell.setVerticalAlignment(tmpCell.getVerticalAlignment());
        if(ctPr2.getTcW()!=null){
            ctPr.addNewTcW().setW(ctPr2.getTcW().getW());
        }
        if(ctPr2.getVAlign()!=null){
            ctPr.addNewVAlign().setVal(ctPr2.getVAlign().getVal());
        }
//        if(cttc2.getPList().size()>0){
//            CTP ctp=cttc2.getPList().get(0);
//            if(ctp.getPPr()!=null){
//                if(ctp.getPPr().getJc()!=null){
//                    cttc.getPList().get(0).addNewPPr().addNewJc().setVal(ctp.getPPr().getJc().getVal());
//                }
//            }
//        }

        if(ctPr2.getTcBorders()!=null){
            ctPr.setTcBorders(ctPr2.getTcBorders());
        }

        XWPFParagraph tmpP=tmpCell.getParagraphs().get(0);
        XWPFParagraph cellP=cell.getParagraphs().get(0);
        XWPFRun tmpR =null;
        if(tmpP.getRuns()!=null&&tmpP.getRuns().size()>0){
            tmpR=tmpP.getRuns().get(0);
        }
        XWPFRun cellR = cellP.createRun();
        cellR.setText(text);
        //复制字体信息
        if(tmpR!=null){
            cellR.setBold(tmpR.isBold());
            cellR.setItalic(tmpR.isItalic());
            cellR.setStrike(tmpR.isStrike());
            cellR.setUnderline(tmpR.getUnderline());
            cellR.setColor(tmpR.getColor());
            cellR.setTextPosition(tmpR.getTextPosition());
            if(tmpR.getFontSize()!=-1){
                cellR.setFontSize(tmpR.getFontSize());
            }
            if(tmpR.getFontFamily()!=null){
                cellR.setFontFamily(tmpR.getFontFamily());
            }
            if(tmpR.getCTR()!=null){
                if(tmpR.getCTR().isSetRPr()){
                    CTRPr tmpRPr =tmpR.getCTR().getRPr();
                    if(tmpRPr.isSetRFonts()){
                        CTFonts tmpFonts=tmpRPr.getRFonts();
                        CTRPr cellRPr=cellR.getCTR().isSetRPr() ? cellR.getCTR().getRPr() : cellR.getCTR().addNewRPr();
                        CTFonts cellFonts = cellRPr.isSetRFonts() ? cellRPr.getRFonts() : cellRPr.addNewRFonts();
                        cellFonts.setAscii(tmpFonts.getAscii());
                        cellFonts.setAsciiTheme(tmpFonts.getAsciiTheme());
                        cellFonts.setCs(tmpFonts.getCs());
                        cellFonts.setCstheme(tmpFonts.getCstheme());
                        cellFonts.setEastAsia(tmpFonts.getEastAsia());
                        cellFonts.setEastAsiaTheme(tmpFonts.getEastAsiaTheme());
                        cellFonts.setHAnsi(tmpFonts.getHAnsi());
                        cellFonts.setHAnsiTheme(tmpFonts.getHAnsiTheme());
                    }
                }
            }
        }
        //复制段落信息
        cellP.setAlignment(tmpP.getAlignment());
        cellP.setVerticalAlignment(tmpP.getVerticalAlignment());
        cellP.setBorderBetween(tmpP.getBorderBetween());
        cellP.setBorderBottom(tmpP.getBorderBottom());
        cellP.setBorderLeft(tmpP.getBorderLeft());
        cellP.setBorderRight(tmpP.getBorderRight());
        cellP.setBorderTop(tmpP.getBorderTop());
        cellP.setPageBreak(tmpP.isPageBreak());
        if(tmpP.getCTP()!=null){
            if(tmpP.getCTP().getPPr()!=null){
                CTPPr tmpPPr = tmpP.getCTP().getPPr();
                CTPPr cellPPr = cellP.getCTP().getPPr() != null ? cellP.getCTP().getPPr() : cellP.getCTP().addNewPPr();
                //复制段落间距信息
                CTSpacing tmpSpacing =tmpPPr.getSpacing();
                if(tmpSpacing!=null){
                    CTSpacing cellSpacing= cellPPr.getSpacing()!=null?cellPPr.getSpacing():cellPPr.addNewSpacing();
                    if(tmpSpacing.getAfter()!=null){
                        cellSpacing.setAfter(tmpSpacing.getAfter());
                    }
                    if(tmpSpacing.getAfterAutospacing()!=null){
                        cellSpacing.setAfterAutospacing(tmpSpacing.getAfterAutospacing());
                    }
                    if(tmpSpacing.getAfterLines()!=null){
                        cellSpacing.setAfterLines(tmpSpacing.getAfterLines());
                    }
                    if(tmpSpacing.getBefore()!=null){
                        cellSpacing.setBefore(tmpSpacing.getBefore());
                    }
                    if(tmpSpacing.getBeforeAutospacing()!=null){
                        cellSpacing.setBeforeAutospacing(tmpSpacing.getBeforeAutospacing());
                    }
                    if(tmpSpacing.getBeforeLines()!=null){
                        cellSpacing.setBeforeLines(tmpSpacing.getBeforeLines());
                    }
                    if(tmpSpacing.getLine()!=null){
                        cellSpacing.setLine(tmpSpacing.getLine());
                    }
                    if(tmpSpacing.getLineRule()!=null){
                        cellSpacing.setLineRule(tmpSpacing.getLineRule());
                    }
                }
                //复制段落缩进信息
                CTInd tmpInd=tmpPPr.getInd();
                if(tmpInd!=null){
                    CTInd cellInd=cellPPr.getInd()!=null?cellPPr.getInd():cellPPr.addNewInd();
                    if(tmpInd.getFirstLine()!=null){
                        cellInd.setFirstLine(tmpInd.getFirstLine());
                    }
                    if(tmpInd.getFirstLineChars()!=null){
                        cellInd.setFirstLineChars(tmpInd.getFirstLineChars());
                    }
                    if(tmpInd.getHanging()!=null){
                        cellInd.setHanging(tmpInd.getHanging());
                    }
                    if(tmpInd.getHangingChars()!=null){
                        cellInd.setHangingChars(tmpInd.getHangingChars());
                    }
                    if(tmpInd.getLeft()!=null){
                        cellInd.setLeft(tmpInd.getLeft());
                    }
                    if(tmpInd.getLeftChars()!=null){
                        cellInd.setLeftChars(tmpInd.getLeftChars());
                    }
                    if(tmpInd.getRight()!=null){
                        cellInd.setRight(tmpInd.getRight());
                    }
                    if(tmpInd.getRightChars()!=null){
                        cellInd.setRightChars(tmpInd.getRightChars());
                    }
                }
            }
        }
    }

	//字符串内容替换
	private   void processParagraphs(List<XWPFParagraph> paragraphList,String from ,String to){
		if(paragraphList != null && paragraphList.size() > 0){
			for(XWPFParagraph paragraph:paragraphList){
				List<XWPFRun> runs = paragraph.getRuns();
				for (XWPFRun run : runs) {
					String text = run.getText(0);
					if(text != null){
							if(text.indexOf(from) != -1){
								//文本替换
								text = text.replace("#{"+from+"}#", to);
								run.setText(text,0);
							}
						}
					}
				}
			}
	}
    //字符串内容替换
    private   void processParagraphs(List<XWPFParagraph> paragraphList,Map<String, Object> param){
        if(paragraphList != null && paragraphList.size() > 0){
            for(XWPFParagraph paragraph:paragraphList){
                List<XWPFRun> runs = paragraph.getRuns();
                for (XWPFRun run : runs) {
                    String text = run.getText(0);
                    if(text != null){
                        for (Map.Entry<String, Object> entry : param.entrySet()) {
                            String key = entry.getKey();
                            if(text.indexOf(key) != -1){
                                Object value = entry.getValue();
                           //文本替换
                                    text = text.replace("#{"+key+"}#", value.toString());
                                    run.setText(text,0);
                            }
                        }
                    }
                }
            }
        }
    }
    
    
    private Map<String, Object> replaceDictionary(Map<String, Object> scanMap){
    	//获取枚举
    	int wpsEnum = DictionaryEnums.WPS.getCode();//WPS状态枚举
    	int privacyEnum = DictionaryEnums.PRIVACY.getCode();//加密方式枚举
    	int broadcastSsidEnum = DictionaryEnums.BROADCAST_SSID.getCode();//是否开启SSID广播枚举
    	int encryptWayEnum = DictionaryEnums.ENCRYPT_WAY.getCode();//加密算法枚举
    	Map<String, Object> map = new HashMap<String, Object>();
    	//int类型枚举转换成字符串
    	String wpsCode = String.valueOf(wpsEnum);
    	String privacyCode = String.valueOf(privacyEnum);
    	String broadcastSsidCode = String.valueOf(broadcastSsidEnum);
    	String encryptWayCode = String.valueOf(encryptWayEnum);
    	if( scanMap.get("privacy")!="" && scanMap.get("privacy")!=null){
    		String str1 = String.valueOf(scanMap.get("privacy"));
    		int str2 = Integer.parseInt(privacyCode.concat(str1));
    		Dictionary str3;
    		String str4;
    		try {
    			str3 =dictionaryBiz.queryDictionaryByPrimary(str2);
    			str4 = str3.getDictionaryValue();
			} catch (Exception e) {
				str4="";
			}
    		
    		map.put("privacyDic", str4);
    	}if( scanMap.get("encryptWay")!="" && scanMap.get("encryptWay")!=null){
    		String str1 = String.valueOf(scanMap.get("encryptWay"));
    		int str2 = Integer.parseInt(encryptWayCode.concat(str1));
    		Dictionary str3;
    		String str4;
    		try {
    			str3 =dictionaryBiz.queryDictionaryByPrimary(str2);
    			str4 = str3.getDictionaryValue();
			} catch (Exception e) {
				str4="";
			}
    		map.put("encryptWayDic", str4);
    	}if( scanMap.get("wps")!="" && scanMap.get("wps")!=null){
    		String str1 = String.valueOf(scanMap.get("wps"));
    		int str2 = Integer.parseInt(wpsCode.concat(str1));
    		Dictionary str3;
    		String str4;
    		try {
    			str3 =dictionaryBiz.queryDictionaryByPrimary(str2);
    			str4 = str3.getDictionaryValue();
			} catch (Exception e) {
				str4="";
			}
    		map.put("wpsDic", str4);
    	}if( scanMap.get("broadcastSsid")!="" && scanMap.get("broadcastSsid")!=null){
    		String str1 = String.valueOf(scanMap.get("broadcastSsid"));
    		int str2 = Integer.parseInt(broadcastSsidCode.concat(str1));
    		Dictionary str3;
    		String str4;
    		try {
    			str3 =dictionaryBiz.queryDictionaryByPrimary(str2);
    			str4 = str3.getDictionaryValue();
			} catch (Exception e) {
				str4="";
			}
    		map.put("broadcastSsidDic", str4);
    	}
    	
    	
    	return map;
    }
    
    
    //获取安全报告需要显示的值
	private Map<String,Object>  getReportMap(){
		Map<String,Object>  map=new HashMap<String,Object>();
		List<Map<String, Object>> apList=apService.queryApMapList();
		List<Map<String, Object>> stationList=scanStationService.queryStation(new HashMap<String, Object>());
		Map<Integer,Object>  channelMap=new HashMap<Integer,Object>();//信道
		Map<String,Object>  saveApMap=new HashMap<String,Object>();//安全Ap
		Map<Integer,Object>  skApMap=new HashMap<Integer,Object>();//风险Ap
		Integer privacy;
		int pri;
		Integer encryptWay;
		Integer wps;
		if(apList!=null&&apList.size()>0){
			map.put(ReportEnum.TAP_SIZE.getCode(),apList.size());//ap总量
			for (Map<String, Object> ap:apList){
            getMapByKey(channelMap,(Integer) ap.get(ReportEnum.CHANNLE.getCode())).add(ap);//ap放入信道
				privacy=(Integer)ap.get("privacy");
				encryptWay=(Integer)ap.get("encryptWay");
				wps=(Integer)ap.get("wps");
				Map<String, Object> scanMap = new HashMap<String, Object>();
				scanMap.put("privacy", privacy);
				scanMap.put("encryptWay", encryptWay);
				scanMap.put("wps", wps);
				scanMap.put("broadcastSsid", ap.get("broadcastSsid"));
				Map<String, Object> mapDic = replaceDictionary(scanMap);
				ap.put("privacy", mapDic.get("privacyDic"));
				ap.put("encryptWay", mapDic.get("encryptWayDic"));
				ap.put("wps", mapDic.get("wpsDic"));
				ap.put("broadcastSsid", mapDic.get("broadcastSsidDic"));
				if(privacy!=null){
					pri=privacy.intValue();
					if(pri==0||pri==1||pri==3||pri==5||pri==7){
                        getMapByKey(skApMap,ApRiskEnum.MAX_RISK.getCode()).add(ap);
					}else if(pri==2&&encryptWay!=null&&encryptWay.intValue()==4) {
                        getMapByKey(skApMap,ApRiskEnum.LESS_RISK.getCode()).add(ap);
					}else if(wps!=null&&wps.intValue()==1){
                        getMapByKey(skApMap,ApRiskEnum.CERTAIN_RISK.getCode()).add(ap);
					}else {
						saveApMap.put((String) ap.get("mac"),ap.get("mac"));
					}
				}

			}

		}else {
			map.put(ReportEnum.TAP_SIZE.getCode(),0);//ap总量
		}

		if (stationList!=null&&stationList.size()>0){
			map.put(ReportEnum.STATION_SIZE.getCode(),stationList.size());//终端总量
		}else {
			map.put(ReportEnum.STATION_SIZE.getCode(),0);//终端总量
		}

		map.put(ReportEnum.SAVEAP_SIZE.getCode(),saveApMap.size());//安全ap总量
		map.put(ReportEnum.SAVEAP_SHOW.getCode() ,saveApMap.values().toString().replace("[","").replace("]",""));//安全ap展示
        map.put(ReportEnum.CHANNLE.getCode() ,channelMap);//信道展示
        map.put(ReportEnum.RISK.getCode(),skApMap);//风险ap

		return  map;
	}



    private Set<Object> getMapByKey(Map<Integer,Object> map, Integer key){
        Set<Object>  resultMap;
        resultMap=(Set<Object>)map.get(key);
        if(resultMap==null){
            resultMap=new HashSet<Object>();
			map.put(key,resultMap);
        }
        return resultMap;
    }


   private  CommonResult strategiesChange(){
	   CommonResult commonResult=new CommonResult();
	   try {
		   SoketBean soketBean=new SoketBean();
		   soketBean.setSoketEnum(SoketEnum.UPDATE_STRATEGY_NOTICE
		   );
		   soketBean.setTime(new Date());
		   soketBean.setNo(UUID.randomUUID().toString());
		   commonResult=   sokectSendService.sendData(soketBean);
	   } catch (Exception e) {
		   logger.error("修改通知异常",e);
	   }
	   return commonResult;
   }



	@Override
	public void queryAlarmsByPage(CommonPage commonPage) {
		List<Map<String,Object>> alarm=service.queryAlarmsByPage(commonPage);

		commonPage.setPageData(alarm);

		

	}

	@Override
	public CommonResult updateFlagById(Map<String, Object> map) {
		CommonResult result=new CommonResult();
		try {
			if(service.updateFlagById(map)){
				result=strategiesChange();
				this.userLogService.insertUserLog(LogTypeEnum.TYPE_UPDATE_STATE, result.getIsSuccess(), "");
			}
			else
			{
				this.userLogService.insertUserLog(LogTypeEnum.TYPE_UPDATE_STATE, result.getIsSuccess(), "");
			}
		}catch (Exception e){
			logger.error("updateFlagById异常",e);
			this.userLogService.insertUserLog(LogTypeEnum.TYPE_UPDATE_STATE, result.getIsSuccess(), "updateFlagById异常");
		}

		return result;
	}

	@Override
	public CommonResult deleteStrategies(List<Integer> strIds) {
		CommonResult result=new CommonResult();
        try {
				if(service.deleteStrategies(strIds)){
					result=strategiesChange();
				}
        }catch (Exception e){
            logger.error("删除策略异常",e);
        }
        return result;
	}

	@Override
	public CommonResult insertStrategy(List<StrategyKey> strategies){
		CommonResult result=new CommonResult();
		try{
			if(strategies!=null){
				for (StrategyKey str : strategies) {
			    service.insertStrategy(str);
				}
				result=strategiesChange();
			}
		}catch(Exception e){
			logger.error("添加策略异常",e);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> queryStrategiesByAlarm(Integer invadeId) {
        List<Map<String, Object>> list= service.queryStrategies(invadeId);
		return list;
	}

	@Override
	public List<Map<String, Object>> queryDefaultStrategiesByAlarm(Integer invadeId) {
		return service.queryDefaultStrategies(invadeId);
	}

	@Override
	public CommonResult updateStrategy(Map<String,Object> map){
		CommonResult result=new CommonResult();
        try{
        	service.updateStrategy(map);
            this.userLogService.insertUserLog(LogTypeEnum.TYPE_UPDATE_DEFENSE, true, "");
		}catch(Exception e){
			logger.error("更新策略异常",e);
			this.userLogService.insertUserLog(LogTypeEnum.TYPE_UPDATE_DEFENSE, true, "更新策略异常");
		}
		return result;
	}
}
