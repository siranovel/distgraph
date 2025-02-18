// 超幾何分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.HypergeometricDistribution;
class HygeChartPlot implements ChartPlot {
    private static HypergeometricDistribution hygeDist = null;
    public HygeChartPlot(int popsize, int nums, int smplsize) {
        hygeDist = new HypergeometricDistribution(popsize, nums, smplsize);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new HygePlot();

        return plot.createPlot(from, to, false);
    }
    private class HygePlot implements CreatePlot {
        public XYSeriesCollection createDataset0(double from, double to) {
            XYSeries p = new XYSeries("P");

            for(int x = (int)from; x < (int)to; x++) {
                p.add(x, hygeDist.probability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(p);
            return series;
        }
        public XYSeriesCollection createDataset1(double from, double to) {
            XYSeries cu = new XYSeries("累積");

            for(int x = (int)from; x < (int)to; x++) {
                cu.add(x, hygeDist.cumulativeProbability(x));
            }
            XYSeriesCollection series = new XYSeriesCollection();
            series.addSeries(cu);
            return series;
        }
    }
}

