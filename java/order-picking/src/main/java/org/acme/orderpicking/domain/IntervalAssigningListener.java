package org.acme.orderpicking.domain;

import ai.timefold.solver.core.api.domain.variable.VariableListener;
import ai.timefold.solver.core.api.score.director.ScoreDirector;
import org.apache.commons.math3.geometry.euclidean.oned.Interval;
import org.jspecify.annotations.NonNull;





public class IntervalAssigningListener implements VariableListener<OrderPickingSolution,TrolleyStep> {
    private static String INTERVAL = "interval";
    @Override
    public void beforeVariableChanged(@NonNull ScoreDirector<OrderPickingSolution> scoreDirector, @NonNull TrolleyStep trolleyStep) {
        if (trolleyStep.getPreviousElement() != null) {
            trolleyStep.setInterval(null);
            if (trolleyStep.getPreviousElement().getNextElement()!=null){
                scoreDirector.beforeVariableChanged(trolleyStep, INTERVAL);
                trolleyStep.setInterval(new Interval(30,40));
                scoreDirector.afterVariableChanged(trolleyStep, INTERVAL);}
            else {
                scoreDirector.beforeVariableChanged(trolleyStep, INTERVAL);
                trolleyStep.setInterval(new Interval(40,50));
                scoreDirector.afterVariableChanged(trolleyStep, INTERVAL);}


        }
    }

    @Override
    public void afterVariableChanged(@NonNull ScoreDirector<OrderPickingSolution> scoreDirector, @NonNull TrolleyStep trolleyStep) {

    }

    @Override
    public void beforeEntityAdded(@NonNull ScoreDirector<OrderPickingSolution> scoreDirector, @NonNull TrolleyStep trolleyStep) {

    }

    @Override
    public void afterEntityAdded(@NonNull ScoreDirector<OrderPickingSolution> scoreDirector, @NonNull TrolleyStep trolleyStep) {

    }

    @Override
    public void beforeEntityRemoved(@NonNull ScoreDirector<OrderPickingSolution> scoreDirector, @NonNull TrolleyStep trolleyStep) {

    }

    @Override
    public void afterEntityRemoved(@NonNull ScoreDirector<OrderPickingSolution> scoreDirector, @NonNull TrolleyStep trolleyStep) {

    }
}

