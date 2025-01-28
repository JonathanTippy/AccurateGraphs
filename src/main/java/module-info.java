module com.jonathantippy.AccurateGraphs {
    requires com.jonathantippy.RationalRange;
    requires com.jonathantippy.MathEvaluator;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive javafx.base;
    opens com.jonathantippy.AccurateGraphs;
    exports com.jonathantippy.AccurateGraphs;
}
