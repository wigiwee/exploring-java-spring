package com.SpringCore.annotations;

import org.springframework.stereotype.Component;

@Component
public class MediaTek  implements MobileProcessor{
	public void process() {
		System.out.println("World's 2nd best CPU");
	}
}
