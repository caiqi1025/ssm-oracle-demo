/*
 * COPYRIGHT. ShenZhen MinSiDa Technology Co., Ltd. 2018.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen GreatVision Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2018年7月21日    nba         Create the class
*/

package com.ssm.demo.timer.impl;

import org.springframework.stereotype.Service;
import com.ssm.demo.timer.TimerService;



/**
 * @FileName TimerServiceImpl.java
 * @Description: 
 *
 * @Date 2018年7月21日 
 * @author nba
 * @version 1.0
 * 
 */
@Service("TimerService")
public class TimerServiceImpl implements TimerService {

	@Override
	public void doService() {
		try {
			System.out.println("【定时任务】开始执行...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
