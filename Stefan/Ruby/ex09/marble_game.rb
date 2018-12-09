class MarbleGame
    attr_reader :circle, :current_player
    
    def initialize(nr_players)
        @nr_players = nr_players
        @current_player = 0
        @circle = [0]
        @current_marble_index = 0
        @scores = Array.new(nr_players, 0)
    end

    def current_marble
        @circle[@current_marble_index]
    end

    def place(marble)
        next_player
        if marble % 23 != 0
            new_marble_index = marble == 1 ? 1 : (@current_marble_index + 2) % @circle.length
            if new_marble_index == 0
                new_marble_index = @circle.length
            end
            @circle.insert(new_marble_index, marble)
            @current_marble_index = new_marble_index
        else
            # First, the current player keeps the marble they would have placed, adding it to their score.
            add_score(marble)
            # In addition, the marble 7 marbles counter-clockwise from the current marble is removed from the circle and also added to the current player's score.
            delete_index = (@current_marble_index - 7) % @circle.length
            add_score(@circle.delete_at(delete_index))
            # The marble located immediately clockwise of the marble that was removed becomes the new current marble.
            @current_marble_index = delete_index
        end
    end

    def next_player
        @current_player = (@current_player + 1) % @nr_players
    end

    def score(player)
        @scores[player - 1]
    end

    def add_score(marble)
        @scores[@current_player - 1] += marble
    end

    def winner
        @scores.each_with_index.max[1] + 1
    end

    def winning_rounds_for(round, player)
        winning_rounds = []
        current_round = player
        while current_round <= round
            winning_rounds << current_round if current_round % 23 == 0
            current_round += @nr_players
        end
        winning_rounds
    end
end