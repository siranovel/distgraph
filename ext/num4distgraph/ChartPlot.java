import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;

import org.jfree.chart.plot.XYPlot;

import java.io.File;
import java.io.IOException;
interface ChartPlot {
    /* メゾット */
    XYPlot createPlot(double from, double to);
    default JFreeChart createChart(String title, double from, double to) {
        XYPlot plot = createPlot(from, to);
        ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
        JFreeChart chart = new JFreeChart(title, plot);

        ChartUtils.applyCurrentTheme(chart);
        return chart;
    }
    default void writeJPEG(String fname, JFreeChart chart, int width, int height) {
        File file = new File(fname);
        try {
            ChartUtils.saveChartAsJPEG(file, chart, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

