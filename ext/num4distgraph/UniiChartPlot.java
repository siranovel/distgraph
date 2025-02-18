// 一様(整数)分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.UniformIntegerDistribution;
class UniiChartPlot implements ChartPlot {
    private static UniformIntegerDistribution uniiDist = null;
    public UniiChartPlot(int low, int up) {
        uniiDist = new UniformIntegerDistribution(low, up);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new UniiPlot();

        return plot.createPlot(from, to, false);
    }
    private class UniiPlot implements CreatePlot {
        public XYSeriesCollection createDataset0(double from, double to) {
            XYSeries p = new XYSeries("P");

            for(int x = (int)from; x < (int)to; x++) {
                p.add(x, uniiDist.probability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(p);
            return series;
        }
        public XYSeriesCollection createDataset1(double from, double to) {
            XYSeries cu = new XYSeries("累積");

            for(int x = (int)from; x < (int)to; x++) {
                cu.add(x, uniiDist.cumulativeProbability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(cu);
            return series;
        }
    }
}

