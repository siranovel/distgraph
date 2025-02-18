// ラプラス分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.LaplaceDistribution;
class LaChartPlot implements ChartPlot {
    private static LaplaceDistribution laDist = null;
    public LaChartPlot(double mu, double beta) {
        laDist = new LaplaceDistribution(mu, beta);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new LaPlot();

        return plot.createPlot(from, to, false);
    }
    private class LaPlot implements CreatePlot {
        public XYSeriesCollection createDataset0(double from, double to) {
            XYSeries p = new XYSeries("P");

            for(double x = from; x < to; x += CreatePlot.DT) {
                p.add(x, laDist.density(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(p);
            return series;
        }
        public XYSeriesCollection createDataset1(double from, double to) {
            XYSeries cu = new XYSeries("累積");

            for(double x = from; x < to; x += CreatePlot.DT) {
                cu.add(x, laDist.cumulativeProbability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(cu);
            return series;
        }
    }
}

