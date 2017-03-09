/**
 *
 */
package jp.co.future.uroborosql.utils;

/** 文字列書式 */
public enum CaseFormat {
	/** キャメルケース（先頭小文字） */
	CamelCase {
		/**
		 * キャメル式文字列に変換する
		 *
		 * <pre>
		 * 	convert("CAMEL")    ⇒	"camel"
		 * 	convert("TO_CAMEL") ⇒	"toCamel"
		 * 	convert("")         ⇒	""
		 * 	convert(null)       ⇒	""
		 * </pre>
		 *
		 * @param original 変換元文字列
		 * @return キャメル式文字列
		 *
		 * @see jp.co.future.uroborosql.utils.CaseFormat#convert(java.lang.String)
		 */
		@Override
		public String convert(final String original) {
			if (original == null || "".equals(original)) {
				return "";
			}
			String str = original.trim();
			if (str.isEmpty()) {
				return str;
			}
			if (!str.contains("_")) {
				char ch = str.charAt(0);
				if ('a' <= ch && ch <= 'z' || '0' <= ch && ch <= '9') {
					// 先頭小文字で"_"を含まない場合（つまりすでにCamelCaseの場合）、文字列変換せずにそのまま返す
					return str;
				}
			}
			StringBuilder builder = new StringBuilder();
			str = str.toLowerCase();
			int i = 0;
			int len = str.length();
			while (i < len) {
				char ch = str.charAt(i);
				if (ch == '_') {
					i++;
					if (i < len) {
						builder.append(Character.toUpperCase(str.charAt(i)));
					}
				} else {
					builder.append(ch);
				}
				i++;
			}
			return builder.toString();
		}
	},
	/** スネーク式文字列（大文字） */
	SnakeCase {
		/**
		 * スネーク式文字列（大文字）に変換する
		 *
		 * <pre>
		 * 	convert("snake")    ⇒	"SNAKE"
		 * 	convert("SNAKE")    ⇒	"SNAKE"
		 * 	convert("toSnake")  ⇒	"TO_SNAKE"
		 * 	convert("")         ⇒	""
		 * 	convert(null)       ⇒	""
		 * </pre>
		 *
		 * @param original 変換元文字列
		 * @return スネーク式文字列（大文字）
		 *
		 * @see jp.co.future.uroborosql.utils.CaseFormat#convert(java.lang.String)
		 */
		@Override
		public String convert(final String original) {
			if (original == null || "".equals(original)) {
				return "";
			}
			String str = original.trim();
			if (str.contains("_") || str.toUpperCase().equals(str)) {
				return str.toUpperCase();
			}

			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if ('a' <= ch && ch <= 'z' || '0' <= ch && ch <= '9') {
					builder.append(Character.toUpperCase(ch));
				} else if ('A' <= ch && ch <= 'Z') {
					if (i > 0) {
						builder.append('_');
					}
					builder.append(ch);
				} else if (ch == '_') {
					builder.append('_');
				}
			}
			return builder.toString();
		}
	};

	/**
	 * 書式の変換を行う
	 *
	 * @param original 変換元書式
	 * @return 変換後文字列
	 */
	public abstract String convert(String original);
}