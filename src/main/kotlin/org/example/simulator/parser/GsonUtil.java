package org.example.simulator.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * 一个简单的Gson序列化与反序列化工具，对gson常用方法做了个包装.
 *
 * @author Ankol
 */
public class GsonUtil {

    private static final Gson gson;

    static {
        gson = new GsonBuilder()
                .create();
    }

    /**
     * 从 JSON 字符串反序列化为 Java 对象，接受一个目标对象的 Class 类型作为参数
     *
     * @param json json字符串
     * @param type 指定的泛型类型，你可以使用{@link TypeToken}获取类型。
     *             <p>例如：你需要获取{@code Collection<Foo>}的类型。你可以使用：</p>
     *             <pre>
     *                 new TypeToken&lt;Collection&lt;Foo&gt;&gt;(){};
     *             </pre> 来获取指定泛型类型。
     */
    public static <T> T fromJson(String json, TypeToken<T> type) {
        return gson.fromJson(json, type.getType());
    }

    /**
     * 从 JSON 字符串反序列化为 Java 对象，接受一个目标对象的 Class 类型作为参数
     *
     * @param json   json字符串
     * @param target 反序列化的目标对象
     * @param <T>    所需对象的类型
     */
    public static <T> T fromJson(String json, Class<T> target) {
        return gson.fromJson(json, target);
    }

    /**
     * 将 Java 对象转换为json字符串
     *
     * @param obj java对象
     */
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * 将 Java 对象按照指定的类型转换为 JSON 字符串。
     *
     * @param obj    对象
     * @param typeof 类型
     * @return json字符串
     */
    public static String toJson(Object obj, Type typeof) {
        return gson.toJson(obj, typeof);
    }

    /**
     * 判断是否是json字符串
     *
     * @param str 字符串
     */
    public static boolean isJsonStr(String str) {
        try {
            JsonParser.parseString(str);
            return true;
        } catch (JsonSyntaxException e) {
            return false;
        }
    }
}
