package org.itstep.myWebApp.web.util;

/**
 * Created by student on 16.03.2017.
 */
public class UtilException {
    public UtilException() {
    }

    public static <T> T check(T entity, Integer id){
        if(entity == null){
            throw new NotFoundException("Not found id = " + id);
        }

        return entity;
    }


}
