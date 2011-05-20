package org.drools.chance.constraints.core.connectives.impl.godel;

import org.drools.chance.constraints.core.connectives.impl.AbstractConnective;
import org.drools.chance.constraints.core.connectives.impl.LOGICCONNECTIVES;
import org.drools.chance.degree.IDegree;

/**
 * Created by IntelliJ IDEA.
 * User: doncat
 * Date: 25/01/11
 * Time: 21.34
 * To change this template use File | Settings | File Templates.
 */
public class And extends AbstractConnective {



    private static And instance = new And();


    private And() { }
    public static And getInstance() {
        return instance;
    }

    public LOGICCONNECTIVES getType() {
        return LOGICCONNECTIVES.AND;
    }



    public IDegree eval(IDegree deg) {
        return deg;
    }


    public IDegree eval(IDegree left, IDegree right) {
        return left.min(right);
    }


    public IDegree eval(IDegree... degs) {
        IDegree deg = degs[0];
        for (int j = 1; j < degs.length; j++) {
            deg = deg.min(degs[j]);
        }
        return deg;
    }




    public boolean isUnary() {
        return false;
    }

    public boolean isBinary() {
        return true;
    }

    public boolean isNary() {
        return true;
    }
}
