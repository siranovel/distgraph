require 'java'
require 'num4distgraph.jar'
require 'jfreechart-1.5.4.jar'
require 'commons-math3-3.6.1.jar'

java_import 'DistGraph'
# 各分布の表示を行う
#  (Apache commoms math3使用)
module Num4DistGraphLib
    class << self
        # 逆正弦分布
        #
        # @overload arcsingraph()
        #   @return [void]  arcSinGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.arcsingraph()
        #   => arcSinGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def arcsingraph()
            DistGraph.arcSinGraph()
        end
        # ベータ分布
        #
        # @overload betagraph(alpha, beta)
        #   @param  [double] alpha alpha
        #   @param  [double] beta  beta
        #   @return [void]  betaGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.betagraph(1.05, 1.05)
        #   => betaGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def betagraph(alpha, beta)
            DistGraph.betaGraph(alpha, beta)
        end
        # 二項分布のグラフ
        #
        # @overload bingraph(trials, p)
        #   @param  [int] trials trials
        #   @param  [double] p  p
        #   @return [void]  binGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.bingraph(20, 0.4)
        #   => binGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def bingraph(trials, p)
            DistGraph.binGraph(trials, p)
        end
        # コーシー分布
        #
        # @overload cauchygraph(median, scale)
        #   @param  [double] median trials
        #   @param  [double] scale  scale
        #   @return [void]  cauchyGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.cauchygraph(0, 1)
        #   => cauchyGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def cauchygraph(median, scale)
            DistGraph.caucyGraph(median, scale)
        end
        # 階２乗分布
        #
        # @overload chi2graph(df)
        #   @param  [double] df  df
        #   @return [void]  chi2Graph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.chi2graph(5.0)
        #   => chi2Graph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def chi2graph(df)
            DistGraph.chi2Graph(df)
        end
        # 実定数分布
        #
        # @overload constrgraph(value)
        #   @param  [double] value  value
        #   @return [void]  constRGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.constrgraph(5.0)
        #   => constRGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def constrgraph(value)
            DistGraph.constrGraph(value)
        end
        # 指数分布
        #
        # @overload expgraph(mean)
        #   @param  [double] mean  mean
        #   @return [void]  expGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.expgraph(5.0)
        #   => expGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def expgraph(mean)
            DistGraph.expGraph(mean)
        end
        # F分布
        #
        # @overload fgraph(nf, df)
        #   @param  [double] nf nf
        #   @param  [double] df  df
        #   @return [void]  fGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.fgraph(10.0, 5.0)
        #    => fGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def fgraph(nf, df)
            DistGraph.fGraph(nf, df)
        end
        # ガンマ分布
        #
        # @overload gagraph(shape, scale)
        #   @param  [double] shape shape
        #   @param  [double] scale  scale
        #   @return [void]  gaGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.gagraph(10.0, 5.0)
        #   => gaGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def gagraph(shape, scale)
            DistGraph.gaGraph(shape, scale)
        end
        # 幾何分布
        #
        # @overload gegraph(p)
        #   @param  [double] p  p
        #   @return [void]  geGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.gegraph(0.4)
        #   => geGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def gegraph(p)
            DistGraph.geGraph(p)
        end
        # ガンベル分布
        #
        # @overload gugraph(mu, beta)
        #   @param  [double] mu mu
        #   @param  [double] beta  beta
        #   @return [void]  guGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.gugraph(10.0, 5.0)
        #   => guGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def gugraph(mu, beta)
            DistGraph.guGraph(mu, beta)
        end
        # 超幾何分布
        #
        # @overload hygegraph(popsize, nums, smplsize)
        #   @param  [int] popsize popsize
        #   @param  [int] nums  nums
        #   @param  [int] smplsize  smplsize
        #   @return [void]  hygeGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.hygegraph(15, 5, 10)
        #   => hygeGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def hygegraph(popsize, nums, smplsize)
            DistGraph.hygeGraph(popsize, nums, smplsize)
        end
        # コルモゴロフ=スミルノフ分布
        #
        # @overload ksgraph(n)
        #   @param  [int] n  n
        #   @return [void]  ksGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.ksgraph(10)
        #   => ksGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def ksgraph(n)
            DistGraph.ksGraph(n)
        end
        # ラプラス分布
        #
        # @overload lagraph(mu, beta)
        #   @param  [double] mu mu
        #   @param  [double] beta  beta
        #   @return [void]  laGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.lagraph(10.0, 5.0)
        #   => laGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def lagraph(mu, beta)
            DistGraph.laGraph(mu, beta)
        end
        # レヴェ分布のグラフ
        #
        # @overload legraph(mu, c)
        #   @param  [double] mu mu
        #   @param  [double] c  c
        #   @return [void]  leGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.legraph(10.0, 5.0)
        #   => leGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def legraph(mu, c)
            DistGraph.leGraph(mu, c)
        end
        # ロジスティック分布
        #
        # @overload loggraph(mu, s)
        #   @param  [double] mu mu
        #   @param  [double] s  s
        #   @return [void]  logGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.loggraph(10.0, 5.0)
        #   => logGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def loggraph(mu, s)
            DistGraph.logGraph(mu, s)
        end
        # 対数正規分布
        #
        # @overload logngraph(scale, shape)
        #   @param  [double] scale scale
        #   @param  [double] shape shape
        #   @return [void]  lognGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.logngraph(10.0, 5.0)
        #   => lognGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def logngraph(scale, shape)
            DistGraph.lognGraph(scale, shape)
        end
        # 正規分布
        #
        # @overload ngraph(mean, sd)
        #   @param  [double] mean mean
        #   @param  [double] sd sd
        #   @return [void]  nGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.ngraph(10,  1.05)
        #   => nGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def ngraph(mean, sd)
            DistGraph.nGraph(mean, sd)
        end
        # 仲上分布
        #
        # @overload nkgraph(mu, omega)
        #   @param  [double] mu mu
        #   @param  [double] omega omega
        #   @return [void]  nkGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.nkgraph(10,  5.0)
        #   => nkGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def nkgraph(mu, omega)
            DistGraph.nkGraph(mu, omega)
        end
        # パレット分布
        #
        # @overload pargraph(scale, shape)
        #   @param  [double] scale scale
        #   @param  [double] shape shape
        #   @return [void]  parGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.pargraph(10,  5.0)
        #   => parGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def pargraph(scale, shape)
            DistGraph.parGraph(scale, shape)
        end
        # パスカル分布
        #
        # @overload pasgraph(r, p)
        #   @param  [int]    r r
        #   @param  [double] p p
        #   @return [void]  pasGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.pasgraph(20, 0.4)
        #   => pasGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def pasgraph(r, p)
            DistGraph.pasGraph(r, p)
        end
        # ポワソン分布
        #
        # @overload pograph(p)
        #   @param  [double] p p
        #   @return [void]  poGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.pograph(0.4)
        #   => poGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def pograph(p)
            DistGraph.poGraph(p)
        end
        # トライアングル分布
        #
        # @overload tglgraph(a, b, c)
        #   @param  [double] a a
        #   @param  [double] b b
        #   @param  [double] c c
        #   @return [void]  tglGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.tglgraph(10, 20, 13)
        #   => tglGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def tglgraph(a, b, c)
            DistGraph.tglGraph(a, b, c)
        end
        # T分布
        #
        # @overload tgraph(df)
        #   @param  [double] df df
        #   @return [void]  tGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.tgraph(10)
        #   => tGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def tgraph(df)
            DistGraph.tGraph(df)
        end
        # 一様(整数)分布
        #
        # @overload uniigraph(low, up)
        #   @param  [int]    low low
        #   @param  [int]    up up
        #   @return [void]  uniiGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.uniigraph(3, 10)
        #   => uniiGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def uniigraph(low, up)
            DistGraph.uniiGraph(low, up)
        end
        # 一様(実数)分布
        #
        # @overload unirgraph(low, up)
        #   @param  [double] low low
        #   @param  [double] up up
        #   @return [void]  unirGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.unirgraph(1.03, 2.05)
        #   => unirGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def unirgraph(low, up)
            DistGraph.unirGraph(low, up)
        end
        # ワイブル分布
        #
        # @overload wblgraph(alpha, beta)
        #   @param  [double] alpha alpha
        #   @param  [double] beta beta
        #   @return [void]  wblGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.wblgraph(5.0, 10.0)
        #   => wblGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def wblgraph(alpha, beta)
            DistGraph.wblGraph(alpha, beta)
        end
        # ジーフ分布
        #
        # @overload zipfgraph(elms, exponent)
        #   @param  [int]    elms     elms
        #   @param  [double] exponent exponent
        #   @return [void]  zipfGraph.jpgファイルを出力
        # @example
        #   Num4DistGraphLib.zipfgraph(10, 0.4)
        #   => zipfGraph.jpg
        # @note
        #   グラフは、jfreechartを使用
        def zipfgraph(elms, exponent)
            DistGraph.zipfGraph(elms, exponent)
        end
    end
end

