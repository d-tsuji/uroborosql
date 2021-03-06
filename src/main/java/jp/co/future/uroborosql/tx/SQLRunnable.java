/**
 * Copyright (c) 2017-present, Future Corporation
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package jp.co.future.uroborosql.tx;

/**
 * SQL実行関数インタフェース
 *
 * @author ota
 */
@FunctionalInterface
public interface SQLRunnable {
	/**
	 * SQL実行
	 */
	void run();
}
