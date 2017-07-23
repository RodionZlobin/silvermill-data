package com.rodion.silvermilldata.entity;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public abstract class IdEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public IdEntity() {
    }

    public abstract T getId();

    @SuppressWarnings("SimplifiableConditionalExpression")
    public boolean equals(Object obj) {
        return this == obj?true:(obj != null && this.getClass().equals(obj.getClass())? Objects.equals(this.getId(), ((IdEntity)obj).getId()):false);
    }

    public int hashCode() {
        return Objects.hashCode(this.getId());
    }

    /*
    public String toString() {
        return ReflectionBasedToStringBuilder.toString(this);
    }
     */


    /*

    private static class ReflectionBasedToStringBuilder {

        private static final Comparator<String> ID_FIRST_COMPARATOR = (s1, s2) -> {
            return s1.startsWith("id=")?-1:(s2.startsWith("id=")?1:0);
        };

        public ReflectionBasedToStringBuilder() {
        }

        public static String toString(Object o) {
            List<String> fields = getFieldRepresentations(o, o.getClass(), Lists.newArrayList());
            return o.getClass().getSimpleName() + "[" + Joiner.on(",").join(fields) + "]";
        }

        @SuppressWarnings("RedundantArrayCreation")
        private static List<String> getFieldRepresentations(Object o, Class clazz, List<String> fields) {
            Field[] var3 = clazz.getDeclaredFields();
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Field field = var3[var5];
                if(!Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);

                    String value;
                    try {
                        value = field.get(o) == null?"null":field.get(o).toString();
                    } catch (Exception var10) {
                        StackTraceElement last = var10.getStackTrace()[0];
                        value = String.format("<<REFLECTION CAUSED %s IN %s:%d>>", new Object[]{var10.getClass().getSimpleName(), last.getFileName(), Integer.valueOf(last.getLineNumber())});
                    }

                    fields.add(field.getName() + "=" + value);
                }
            }

            if(clazz.getSuperclass() != null) {
                getFieldRepresentations(o, clazz.getSuperclass(), fields);
            }

            fields.sort(ID_FIRST_COMPARATOR);
            return fields;
        }
    }
     */

}
