package com.bs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bs.SocialMedia;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SocialMedia.class)
@WebAppConfiguration
public class SocialMediaTests {

	@Test
	public void contextLoads() {
	}

}
