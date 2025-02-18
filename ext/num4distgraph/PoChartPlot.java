// ポワソン分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.PoissonDistribution;
class PoChartPlot implements ChartPlot {
    private static PoissonDistribution poDist = null;
    public PoChartPlot(double p) {
        poDist = new PoissonDistribution(p);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new PoPlot();

        return plot.createPlot(from, to, false);
    }
    private class PoPlot implements CreatePlot {
        public XYSeriesCollection createDataset0(double from, double to) {
            XYSeries p = new XYSeries("P");

            for(int x = (int)from; x < (int)to; x++) {
                p.add(x, poDist.probability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(p);
            return series;
        }
        public XYSeriesCollection createDataset1(double from, double to) {
            XYSeries cu = new XYSeries("累積");

            for(int x = (int)from; x < (int)to; x++) {
                cu.add(x, poDist.cumulativeProbability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(cu);
            return series;
        }
    }
}

