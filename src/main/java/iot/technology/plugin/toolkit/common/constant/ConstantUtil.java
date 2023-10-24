package iot.technology.plugin.toolkit.common.constant;

import iot.technology.plugin.toolkit.common.util.Strings;

import java.util.*;

public abstract class ConstantUtil {
    public static List<String> getIdList(Class<? extends Constant> constantClass) {
        return toIdList(Arrays.asList(constantClass.getEnumConstants()));
    }

    public static String[] getIdArray(Class<? extends Constant> constantClass) {
        List<String> idList = toIdList(Arrays.asList(constantClass.getEnumConstants()));
        return idList.toArray(new String[0]);
    }


    public static List<String> toIdList(List<? extends Constant> constants) {
        List<String> ids = new ArrayList<>(constants.size());
        for (Constant constant : constants) {
            ids.add(constant.id());
        }
        Collections.sort(ids);
        return ids;
    }

    public static <T extends Constant> List<T> toConstantsList(List<String> ids, Class<T> constantClass) {
        List<T> constants = new ArrayList<>(ids.size());
        T[] allConstants = constantClass.getEnumConstants();
        for(String id : ids) {
            for (T t : allConstants) {
                if (Objects.equals(t.id(), id)) {
                    constants.add(t);
                    break;
                }

            }
        }
        return constants;
    }

    public static <T extends Constant> boolean isOneOf(T constant, T ... constants) {
        if (constants != null && constants.length > 0) {
            for (T c : constants) {
                if (c == constant) {
                    return true;
                }
            }
        }

        return false;
    }

    public static <T extends Constant> T get(T[] constants, String id, boolean throwException) {
        T constant = get(constants, id);
        if (!Strings.isEmpty(id) && constant == null && throwException) {
            String className = constants[0].getClass().getSimpleName();
            throw new IllegalArgumentException("Invalid " + className + ": '" + id + "'.");
        }
        return constant;
    }

    public static <T extends Constant> T get(T[] constants, String id, T defaultConstant) {
        T constant = get(constants, id);
        return constant == null ? defaultConstant : constant;
    }

    public static <T extends Constant> T get(T[] constants, String id) {
        if (Strings.isNotEmpty(id)){
            for (T constant : constants) {
                if (Objects.equals(constant.id(), id)) {
                    return constant;
                }
            }
        }
        return null;
    }

    public static String toId(Constant constant) {
        return constant == null ? null : constant.id();
    }


    public static <T extends Constant> boolean isValid(String id, T[] constants) {
        T constant = get(constants, id);
        return constant != null;
    }
}
