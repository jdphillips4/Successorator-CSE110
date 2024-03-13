package edu.ucsd.cse110.successorator.data.db;

import androidx.annotation.NonNull;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Objects;

import edu.ucsd.cse110.successorator.lib.domain.Goal;

@Entity(tableName = "goals")
public class GoalEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public Integer id = null;

    @ColumnInfo(name = "text")
    public String mit;

    @ColumnInfo(name = "sort_order")
    public int sortOrder;

    @ColumnInfo(name = "is_crossed")
    public boolean isCrossed;

    @ColumnInfo(name = "frequency")
    public Goal.Frequency frequency;

    @ColumnInfo(name = "goalContext")
    public Goal.GoalContext goalContext;

    GoalEntity(int id, @NonNull String mit, int sortOrder, boolean isCrossed, Goal.Frequency frequency, Goal.GoalContext goalContext) {
        this.id = id;
        this.mit = mit;
        this.sortOrder = sortOrder;
        this.isCrossed = isCrossed;
        this.frequency = frequency;
        this.goalContext = goalContext;
    }

    public static GoalEntity fromGoal(@NonNull Goal goal) {
        //goalEntity.id = goal.id();
        var goalEntity = new GoalEntity(Objects.requireNonNull(goal.id()),
                Objects.requireNonNull(goal.mit()),
                goal.sortOrder(),
                goal.isCrossed(),
                goal.frequency(),
                goal.goalContext()
        );
        return goalEntity;
    }

    public @NonNull Goal toGoal() {
        return new Goal(id, mit, sortOrder, isCrossed,frequency,goalContext);
    }

}
