/* **************************************************************************
 *   (c) Copyright 2017 Zilliant Inc. All rights reserved.                  *
 * **************************************************************************
 *                                                                          *
 *  THIS MATERIAL IS PROVIDED "AS IS." ZILLIANT INC. DISCLAIMS ALL          *
 *  WARRANTIES OF ANY KIND WITH REGARD TO THIS MATERIAL, INCLUDING,         *
 *  BUT NOT LIMITED TO ANY IMPLIED WARRANTIES OF NONINFRINGEMENT,           *
 *  MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.                   *
 *                                                                          *
 *  Zilliant Inc. shall not be liable for errors contained herein           *
 *  or for incidental or consequential damages in connection with the       *
 *  furnishing, performance, or use of this material.                       *
 *                                                                          *
 *  Zilliant Inc. assumes no responsibility for the use or reliability      *
 *  of interconnected equipment that is not furnished by Zilliant Inc,      *
 *  or the use of Zilliant software with such equipment.                    *
 *                                                                          *
 *  This document or software contains trade secrets of Zilliant Inc. as    *
 *  well as proprietary information which is protected by copyright.        *
 *  All rights are reserved.  No part of this document or software may be   *
 *  photocopied, reproduced, modified or translated to another language     *
 *  without prior written consent of Zilliant Inc.                          *
 *                                                                          *
 *  ANY USE OF THIS SOFTWARE IS SUBJECT TO THE TERMS AND CONDITIONS         *
 *  OF A SEPARATE LICENSE AGREEMENT.                                        *
 *                                                                          *
 *  The information contained herein has been prepared by Zilliant Inc.     *
 *  solely for use by Zilliant Inc., its employees, agents and customers.   *
 *  Dissemination of the information and/or concepts contained herein to    *
 *  other parties is prohibited without the prior written consent of        *
 *  Zilliant Inc..                                                          *
 *                                                                          *
 *  (c) Copyright 2017 by Zilliant.  All rights reserved.                   *
 *                                                                          *
 ****************************************************************************/

package org.localprojects.vipdb.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SerenityRunner.class)
public class InitialTest {
    @Managed(uniqueSession = true, driver = "chrome")
    WebDriver driver;

    @Test
    public void test01() {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);

        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("firefly", Keys.ENTER);

        assertThat(driver.getTitle()).isEqualTo("firefly - Пошук Google");
        assertEquals("NOT EQUAL", "firefly - Пошук Google", driver.getTitle());
    }
}
