package com.codingapi.push.server;

import com.alibaba.fastjson.JSON;
import com.codingapi.push.server.ao.PushTagMapReq;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerPushApplicationTests {

	@Test
	public void contextLoads() {
		Map<String,String> map = new HashMap<>();
		map.put("name","名字");
		map.put("value","值");

		PushTagMapReq pushTagMapReq = new PushTagMapReq();
		pushTagMapReq.setApplicationId(1);
		pushTagMapReq.setContent("123");
		pushTagMapReq.setMap(map);
		pushTagMapReq.setTag("tag");
		System.out.println("JSON = " + JSON.toJSONString(pushTagMapReq));
	}

}
