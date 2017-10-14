package com.rodion.silvermilldata.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Objects;


public abstract class ValueObject implements Serializable {

    public ValueObject() {
    }

    @JsonIgnore
    protected abstract Object[] getIdFields();

    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        } else if(obj != null && this.getClass().equals(obj.getClass())) {
            Object[] a = this.getIdFields();
            Object[] b = ((ValueObject)obj).getIdFields();
            if(a == b) {
                return true;
            } else if(a != null && b != null) {
                if(a.length != b.length) {
                    return false;
                } else {
                    for(int i = 0; i < a.length; ++i) {
                        if(!Objects.equals(a[i], b[i])) {
                            return false;
                        }
                    }

                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        int hashCode = 0;
        Object[] var2 = this.getIdFields();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Object idField = var2[var4];
            if(idField != null) {
                hashCode ^= idField.hashCode();
            }
        }

        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Object[] var2 = this.getIdFields();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Object field = var2[var4];
            if(sb.length() > 0) {
                sb.append(",");
            }

            sb.append(field == null ? "null" : field.toString());
        }

        return sb.toString();
    }
}
