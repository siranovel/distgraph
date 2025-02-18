// 指数分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.ExponentialDistribution;
class ExpChartPlot implements ChartPlot {
    private static ExponentialDistribution expDist = null;
    public ExpChartPlot(double mean) {
        expDist = new ExponentialDistribution(mean);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new ExpPlot();

        return plot.createPlot(from, to, false);
    }
    private class ExpPlot implements CreatePlot {
        public XYSeriesCollection createDataset0(double from, double to) {
            XYSeries p = new XYSeries("P");

            for(double x = from; x < to; x += CreatePlot.DT) {
                p.add(x, expDist.density(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(p);
            return series;
       }
       public XYSeriesCollection createDataset1(double from, double to) {
            XYSeries cu = new XYSeries("累積");

            for(double x = from; x < to; x += CreatePlot.DT) {
                cu.add(x, expDist.cumulativeProbability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(cu);
            return series;
        }
    }
}

