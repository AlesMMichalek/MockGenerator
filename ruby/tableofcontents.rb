require 'mustache'
require 'json'

contents = []
Dir.glob('examples/*.json') do |file|
  contents.push(
      title: JSON.parse(File.read(file))['title'],
      link: file.sub('examples/', '').sub('.json', '.md')
  )
end

class TableOfContents < Mustache
end

template = TableOfContents.new
template[:item] = contents
File.write('../documentation/README.md', template.render)
