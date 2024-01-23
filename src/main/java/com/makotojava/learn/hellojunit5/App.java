package com.makotojava.learn.hellojunit5;

/*
 * Copyright 2017 Makoto Consulting Group, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class App {

  /**
   * Computes the sum of the specified operands.
   *
   * As an exercise, implement this method so that all of the unit tests
   * you write for it pass. Once you do that, you're done!
   *
   * Hint: if you get stuck, have a look
   * {@link com.makotojava.learn.hellojunit5.solution.App here}.
   *
   * @param operands
   *          These are the operands. It's sort of there in the name.
   *
   * @return long - The computed sum.
   *
   * @throws IllegalArgumentException
   *           If the specified array of operands is empty or long.
   *           This is definitely an overreaction, but this is sample
   *           code, son.
   */
  public long add(long[] operands) {
    // Compute the sum

    if (operands == null) {
      throw new IllegalArgumentException("Operands argument cannot be null");
    }
    if (operands.length == 0) {
      throw new IllegalArgumentException("Operands argument cannot be empty");
    }
    long ret = 0;
    for (long operand : operands) {
      ret += operand;
    }
    // TDD - add this once we run all the unit tests.
    //
    // TODO: As an exercise, implement this method so that all of the unit tests
    /// you write for it pass. Once you do that, you're done!
    //
    // Hint: if you get stuck, look at the {@link com.makotojava.learn.hellojunit5.solution.App App class}
    //
    return ret;
  }
}
