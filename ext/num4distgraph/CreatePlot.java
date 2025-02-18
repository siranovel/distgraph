import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;

import java.text.DecimalFormat;

interface CreatePlot {
    /* フィールド */
    static final double DT = 0.001;
    /* メゾット */
    XYSeriesCollection createDataset0(double from, double to);
    XYSeriesCollection createDataset1(double from, double to);
    default XYPlot createPlot(double from, double to, boolean xfmt) {
        // Renderer
        XYItemRenderer renderer0 = new XYLineAndShapeRenderer(true, false);
        XYItemRenderer renderer1 = new XYLineAndShapeRenderer(true, false);
        XYToolTipGenerator toolTipGenerator = new StandardXYToolTipGenerator();

        renderer0.setDefaultToolTipGenerator(toolTipGenerator);
        renderer1.setDefaultToolTipGenerator(toolTipGenerator);
        // XYPlot
        XYPlot plot = new XYPlot();

        plot.setOrientation(PlotOrientation.VERTICAL);
        plot.mapDatasetToRangeAxis(0,0);
        plot.mapDatasetToRangeAxis(1,1);
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        /*--- 横軸 ---*/
        NumberAxis domainAxis = new NumberAxis("x");

        plot.setDomainAxis(domainAxis);
        domainAxis.setLowerBound(from);
        domainAxis.setUpperBound(to);
        if (true == xfmt) {
            domainAxis.setTickUnit(new NumberTickUnit(0.1));
            domainAxis.setNumberFormatOverride(new DecimalFormat("0.0#"));
        }
        /*--- 縦軸 ---*/
        NumberAxis valueAxis0 = new NumberAxis("密度");
        NumberAxis valueAxis1 = new NumberAxis("P");

        plot.setRangeAxis(0, valueAxis0);
        plot.setRenderer(0, renderer0);
        plot.setDataset(0, createDataset0(from, to));
        valueAxis0.setLowerBound(0.0);

        plot.setRangeAxis(1, valueAxis1);
        plot.setRenderer(1, renderer1);
        plot.setDataset(1, createDataset1(from, to));
        valueAxis1.setLowerBound(0.0);
        valueAxis1.setUpperBound(1.0);
        valueAxis1.setTickUnit(new NumberTickUnit(0.1));
        valueAxis1.setNumberFormatOverride(new DecimalFormat("0.0#"));
        return plot;
    }
}

