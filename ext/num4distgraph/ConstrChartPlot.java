// 実定数分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.ConstantRealDistribution;
class ConstrChartPlot implements ChartPlot {
    private static ConstantRealDistribution constRDist = null;
    public ConstrChartPlot(double value) {
        constRDist = new ConstantRealDistribution(value);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new ConstrPlot();

        return plot.createPlot(from, to, false);
    }
    private class ConstrPlot implements CreatePlot {
        public XYSeriesCollection createDataset0(double from, double to) {
            XYSeriesCollection series = new XYSeriesCollection();
            return series;
        }
        public XYSeriesCollection createDataset1(double from, double to) {
            XYSeries cu = new XYSeries("累積");

            for(double x = from; x < to; x += CreatePlot.DT) {
                cu.add(x, constRDist.cumulativeProbability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(cu);
            return series;
        }
    }
}

