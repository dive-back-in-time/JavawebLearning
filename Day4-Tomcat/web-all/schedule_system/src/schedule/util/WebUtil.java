package schedule.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schedule.common.Result;

import java.io.BufferedReader;
import java.io.IOException;

public class WebUtil {
    private static ObjectMapper map  = new ObjectMapper();

    //相应json串
    public static void writeJson(HttpServletResponse resp, Result result) {
        resp.setContentType("application/json;charset = UTF-8");
        try {
            String info = map.writeValueAsString(result);
            resp.getWriter().write(info);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // 从请求中获取JSON串并转换为Object
    public static <T> T readJson(HttpServletRequest request, Class<T> clazz){
        T t =null;
        BufferedReader reader = null;
        try {
            reader = request.getReader();
            StringBuffer buffer =new StringBuffer();
            String line =null;
            while((line = reader.readLine())!= null){
                buffer.append(line);
            }

            t= map.readValue(buffer.toString(),clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return t;
    }
}
