// パスカル分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.PascalDistribution;
class PasChartPlot implements ChartPlot {
    private static PascalDistribution pasDist = null;
    public PasChartPlot(int r, double p) {
        pasDist = new PascalDistribution(r, p);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new PasPlot();

        return plot.createPlot(from, to, false);
    }
    private class PasPlot implements CreatePlot {
        public XYSeriesCollection createDataset0(double from, double to) {
            XYSeries p = new XYSeries("P");

            for(int x = (int)from; x < (int)to; x++) {
                p.add(x, pasDist.probability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(p);
            return series;
        }
        public XYSeriesCollection createDataset1(double from, double to) {
            XYSeries cu = new XYSeries("累積");

            for(int x = (int)from; x < (int)to; x++) {
                cu.add(x, pasDist.cumulativeProbability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(cu);
            return series;
        }
    }
} 

