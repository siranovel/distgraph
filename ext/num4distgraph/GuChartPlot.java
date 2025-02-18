// ガンベル分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.GumbelDistribution;
class GuChartPlot implements ChartPlot {
    private static GumbelDistribution guDist = null;
    public GuChartPlot(double mu, double beta) {
        guDist = new GumbelDistribution(mu, beta);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new GuPlot();

        return plot.createPlot(from, to, false);
    }
    private class GuPlot implements CreatePlot {
        public XYSeriesCollection createDataset0(double from, double to) {
            XYSeries p = new XYSeries("P");

            for(double x = from; x < to; x += CreatePlot.DT) {
                p.add(x, guDist.density(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(p);
            return series;
        }
        public XYSeriesCollection createDataset1(double from, double to) {
            XYSeries cu = new XYSeries("累積");

            for(double x = from; x < to; x += CreatePlot.DT) {
                cu.add(x, guDist.cumulativeProbability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(cu);
            return series;
        }
    }
}

