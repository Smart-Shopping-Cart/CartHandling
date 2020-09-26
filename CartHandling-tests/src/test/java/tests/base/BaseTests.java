package tests.base;


import com.mongodb.MongoClient;
import db.config.DBConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import recognition.config.ServiceConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceConfig.class, DBConfig.class} )
public abstract class BaseTests {

    @MockBean
    MongoClient mongoClient;


    @Test
    public void bind serviceWorks()
    {
        when().
    }



}
