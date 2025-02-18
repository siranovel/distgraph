// 対数正規分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.LogNormalDistribution;
class LognChartPlot implements ChartPlot {
    private static LogNormalDistribution lognDist = null;
    public LognChartPlot(double scale, double shape) {
        lognDist = new LogNormalDistribution(scale, shape);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new LognPlot();

        return plot.createPlot(from, to, false);
    }
    private class LognPlot implements CreatePlot {
        public XYSeriesCollection createDataset0(double from, double to) {
            XYSeries p = new XYSeries("P");

            for(double x = from; x < to; x += CreatePlot.DT) {
                p.add(x, lognDist.density(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(p);
            return series;
        }
        public XYSeriesCollection createDataset1(double from, double to) {
            XYSeries cu = new XYSeries("累積");

            for(double x = from; x < to; x += CreatePlot.DT) {
                cu.add(x, lognDist.cumulativeProbability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(cu);
            return series;
        }
    }
}

