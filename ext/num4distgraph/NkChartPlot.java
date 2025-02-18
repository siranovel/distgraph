    // 仲上分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.NakagamiDistribution;
class NkChartPlot implements ChartPlot {
    private static NakagamiDistribution nkDist = null;
    public NkChartPlot(double mu, double omega) {
        nkDist = new NakagamiDistribution(mu, omega);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new NkPlot();

        return plot.createPlot(from, to, false);
    }
    private class NkPlot implements CreatePlot {
        public XYSeriesCollection createDataset0(double from, double to) {
            XYSeries p = new XYSeries("P");

            for(double x = from; x < to; x += CreatePlot.DT) {
                p.add(x, nkDist.density(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(p);
            return series;
        }
        public XYSeriesCollection createDataset1(double from, double to) {
            XYSeries cu = new XYSeries("累積");

            for(double x = from; x < to; x += CreatePlot.DT) {
                cu.add(x, nkDist.cumulativeProbability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(cu);
            return series;
        }
    }
} 

