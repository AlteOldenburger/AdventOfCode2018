require './marble_game.rb'

game = MarbleGame.new(446)
1.upto(71522) { |marble| game.place(marble) }
puts game.score(game.winner)

game = MarbleGame.new(446)
1.upto(7152200) { |marble| game.place(marble) }
puts game.score(game.winner)
