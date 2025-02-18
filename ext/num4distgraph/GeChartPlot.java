// 幾何分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.GeometricDistribution;
class GeChartPlot implements ChartPlot {
    private static GeometricDistribution geDist = null;
    public GeChartPlot(double p) {
        geDist = new GeometricDistribution(p);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new GePlot();

        return plot.createPlot(from, to, false);
    }
    private class GePlot implements CreatePlot {
        public XYSeriesCollection createDataset0(double from, double to) {
            XYSeries p = new XYSeries("P");

            for(int x = (int)from; x < (int)to; x++) {
                p.add(x, geDist.probability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(p);
            return series;
        }
        public XYSeriesCollection createDataset1(double from, double to) {
            XYSeries cu = new XYSeries("累積");

            for(int x = (int)from; x < (int)to; x++) {
                cu.add(x, geDist.cumulativeProbability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(cu);
            return series;
        }
    }
}

