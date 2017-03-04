package test;

import com.xqls.dal.dao.BlockDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Skeyedu on 2017/3/2.
 */
public class BlockDaoTest  extends  BasicTest {
   @Autowired  BlockDao blockDao;

    @Test
    public  void  test(){
        blockDao.queryByKey(1);

    }
}
