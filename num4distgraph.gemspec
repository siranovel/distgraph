Gem::Specification.new do |s|
  s.name          = 'num4distgraph'
  s.version       = '0.0.1'
  s.date          = '2023-11-29'
  s.summary       = "num for distribution graph."
  s.description   = "numerical solution for graph of distribution."
  s.authors       = ["siranovel"]
  s.email         = "siranovel@gmail.com"
  s.homepage      = "http://github.com/siranovel/num4distgraph"
  s.license       = "MIT"
  s.platform      = "java"
  s.files       = ["LICENSE", "Gemfile", "CHANGELOG.md"]
  s.files       += Dir.glob("{lib,ext}/**/*")
  s.extensions  = %w[Rakefile]
  s.add_development_dependency 'rake', '~> 12.3', '>= 12.3.3'
  s.add_development_dependency 'rake-compiler', '~> 1.2', '>= 1.2.5'
end
