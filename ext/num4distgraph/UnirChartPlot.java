// 一様(実数)分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.UniformRealDistribution;
class UnirChartPlot implements ChartPlot {
    private static UniformRealDistribution unirDist = null;
    public UnirChartPlot(double low, double up) {
        unirDist = new UniformRealDistribution(low, up);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new UnirPlot();

        return plot.createPlot(from, to, false);
    }
    private class UnirPlot implements CreatePlot {
        public XYSeriesCollection createDataset0(double from, double to) {
            XYSeries p = new XYSeries("P");

            for(double x = from; x < to; x += CreatePlot.DT) {
                p.add(x, unirDist.density(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(p);
            return series;
        }
        public XYSeriesCollection createDataset1(double from, double to) {
            XYSeries cu = new XYSeries("累積");

            for(double x = from; x < to; x += CreatePlot.DT) {
                cu.add(x, unirDist.cumulativeProbability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(cu);
            return series;
        }
    }
}

