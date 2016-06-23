public class SnakeGame {
    Queue<Integer> snake;
    int width, height, head, foodId;
    int[][] food;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.snake = new LinkedList<>();
        this.snake.offer(0);
        this.width = width;
        this.height = height;
        this.food = food;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int x = head / width;
        int y = head % width;
        
        switch (direction) {
            case "U": 
                x--;
                break;
            case "L": 
                y--;
                break;
            case "R": 
                y++;
                break;
            case "D": 
                x++;
                break;
            default: 
                break;
        }
        
        if (x < 0 || x >= height || y < 0 || y >= width) return -1;
        
        int newHead = x * width + y;
        
        boolean eat = false;
        if (foodId < food.length) {
            int foodPos = food[foodId][0] * width + food[foodId][1];
            if (newHead == foodPos) {
                eat = true;
                foodId++;
            }
        }
        
        if (!eat) {
            snake.poll();
        }
        
        if (snake.contains(newHead)) return -1;
        
        snake.offer(newHead);
        head = newHead;
        
        return foodId;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */