package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Object obj) {
        List<String> result = new ArrayList<>();

        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(NotNull.class)) {
                    field.setAccessible(true);
                    if (field.get(obj) == null) {
                        result.add(field.getName());
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> result = new HashMap<>();

        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);

                List<String> errors = new ArrayList<>();

                if (field.isAnnotationPresent(NotNull.class) && field.get(obj) == null)
                {
                    errors.add("can not be null");
                }

                if (field.isAnnotationPresent(MinLength.class)) {
                    MinLength minLength = field.getAnnotation(MinLength.class);
                    if (field.get(obj) == null || field.get(obj).toString().length() < minLength.minLength())
                    errors.add("length less than " + minLength.minLength());
                }

                if (!errors.isEmpty()) {
                    result.put(field.getName(), errors);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        return result;

    }
}

// END
