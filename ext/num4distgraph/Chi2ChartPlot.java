// 階２乗分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.ChiSquaredDistribution;
class Chi2ChartPlot implements ChartPlot {
    private static ChiSquaredDistribution chi2Dist = null;
    public Chi2ChartPlot(double df) {
        chi2Dist = new ChiSquaredDistribution(df);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new Chi2Plot();

        return plot.createPlot(from, to, false);
    }
    private class Chi2Plot implements CreatePlot {
        public XYSeriesCollection createDataset0(double from, double to) {
            XYSeries p = new XYSeries("P");

            for(double x = from; x < to; x += CreatePlot.DT) {
                p.add(x, chi2Dist.density(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(p);
            return series;
        }
        public XYSeriesCollection createDataset1(double from, double to) {
            XYSeries cu = new XYSeries("累積");

            for(double x = from; x < to; x += CreatePlot.DT) {
                cu.add(x, chi2Dist.cumulativeProbability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(cu);
            return series;
        }
    }
}

