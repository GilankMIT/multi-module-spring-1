/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.common.util.helper;

import java.util.Random;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: StringRandomizer.java, v 0.1 2023‐09‐28 01.34 gilang.prambudi Exp $$
 */
public class StringHelper {
   public static String generateRandomString(int length) {
      // Define the characters to choose from
      String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

      // Create a StringBuilder to store the random string
      StringBuilder randomStringBuilder = new StringBuilder(length);

      // Create an instance of Random
      Random random = new Random();

      // Generate random characters and append them to the StringBuilder
      for (int i = 0; i < length; i++) {
         int randomIndex = random.nextInt(characters.length());
         char randomChar = characters.charAt(randomIndex);
         randomStringBuilder.append(randomChar);
      }

      // Convert the StringBuilder to a String and return
      return randomStringBuilder.toString();
   }
}