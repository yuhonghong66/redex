/**
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package redex.test.instr;

import static org.fest.assertions.api.Assertions.*;
import org.junit.*;

public class StringConcatenatorTest {
  public static final String prefix = "pre";
  public static final String concatenated = fake_clinit();

  // run simpleinline first to make this the real <clinit>
  private static String fake_clinit() {
    StringBuilder b = new StringBuilder();
    b.append(prefix);
    b.append("stuff");
    return b.toString();
  }

  @Test
  public void test() {
    assertThat(concatenated).isEqualTo("prestuff");
  }
}
