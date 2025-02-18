// ベータ分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.BetaDistribution;
class BetaChartPlot implements ChartPlot {
    private static BetaDistribution beDist = null;
    public BetaChartPlot(double alpha, double beta) {
        beDist = new BetaDistribution(alpha, beta);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new BetaPlot();

        return plot.createPlot(from, to, true);
    }
    private class BetaPlot implements CreatePlot {
        public XYSeriesCollection createDataset0(double from, double to) {
            XYSeries p = new XYSeries("P");

            for(double x = from + CreatePlot.DT; x < to; x += CreatePlot.DT) {
                p.add(x, beDist.density(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(p);
            return series;
        }
        public XYSeriesCollection createDataset1(double from, double to) {
            XYSeries cu = new XYSeries("累積");

            for(double x = from; x < to; x += CreatePlot.DT) {
                cu.add(x, beDist.cumulativeProbability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(cu);
            return series;
        }
    }
}

