/*
 * Copyright 2011 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.chance.distribution.fuzzy.linguistic;

import org.drools.chance.common.ImperfectField;
import org.drools.chance.common.ImperfectFieldImpl;
import org.drools.chance.degree.Degree;
import org.drools.chance.distribution.Distribution;
import org.drools.chance.distribution.DistributionStrategies;

import java.util.Map;

public class LinguisticImperfectField<T extends Linguistic, K extends Number> implements ImperfectField<T> {

    ImperfectField<T> innerField;

    protected DistributionStrategies<K> subStrats;



    public LinguisticImperfectField( DistributionStrategies<T> strats, DistributionStrategies<K> subStrats, String prior) {
        innerField = new ImperfectFieldImpl<T>(strats,prior);

        this.subStrats = subStrats;
    }

    public void setValue(T value) {
        innerField.setValue(value);
    }

    public void setValue( T value, boolean update ) {
        innerField.setValue( value,update );
    }

    public void setValue(T value, Degree deg, String... params) {
         innerField.setValue( value, deg, params );
    }

    public void setValue(Distribution<T> dist) {
        innerField.setValue(dist);
    }

    public void setValue(Distribution<T> dist, boolean update) {
        innerField.setValue(dist,update);
    }

    public boolean isSet() {
        return innerField.isSet();
    }

    public T getCrisp() {
        return innerField.getCrisp();
    }

    public Distribution<T> getPast(int time) throws IndexOutOfBoundsException {
        return innerField.getPast(time);
    }

    public Distribution<T> getCurrent() {
        return innerField.getCurrent();
    }

    public DistributionStrategies<T> getStrategies() {
        return innerField.getStrategies();
    }

    public void update(Distribution<T> fieldBit) {
        innerField.update(fieldBit);
    }

    public void update(T value) {
        innerField.update(value);
    }

    public void update(T value, Degree deg, String... p) {
        innerField.update( value, deg, p );
    }

    public void remove(T value, Degree deg, String... p) {
        //TODO
        throw new UnsupportedOperationException("TODO");
    }


    public String toString() {
        return "(L)" + innerField.toString();
    }



    public Number defuzzify() {
        Number ans = subStrats.toCrispValue(
                ( (ShapedFuzzyPartition) innerField.getCurrent() ).asInducedPossibilityDistribution() );
        return ans;
    }


    public Distribution<T> fuzzify(Number val) {
        Map<? extends T,? extends Degree> m = ( (ShapedFuzzyPartition) innerField.getCurrent() ).fuzzify( val );
        return getStrategies().newDistribution( m );
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinguisticImperfectField that = (LinguisticImperfectField) o;

        if (innerField != null ? !innerField.equals(that.innerField) : that.innerField != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return innerField != null ? innerField.hashCode() : 0;
    }
}
