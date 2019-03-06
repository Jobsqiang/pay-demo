package com.qiangjiang.demo;

import com.qiangjiang.demo.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private UserController userController;

    @Test
    public void contextLoads() {
    }

    @Test
    public void insert(){
        String fileName ="D:\\test1.txt";
        try (FileReader reader = new FileReader(fileName);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            //网友推荐更加简洁的写法   M100000866
            List<String> list = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                list.add(line);
            }
            System.out.println(list);
            for(int i = 0 ; i< list.size();i++){
//                userController.insert(list.get(i).replace("\n","").replace("\r","").replace("\t",""));
                userController.insert(list.get(i));
                System.out.println("第【"+i+"】行");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
