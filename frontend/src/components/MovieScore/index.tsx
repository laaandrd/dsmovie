import MovieStars from 'components/MovieStars';
import './styles.css';

function MovieScore() {

    var score = 3.5;
    var count = 2;

    return (
        <div className="dsmovie-score-container">
            <p className="dsmovie-score-value">{score > 0 ? score.toFixed(2) : '-'}</p>
            <MovieStars />
            <p className="dsmovie-score-count">{count} avaliações</p>
        </div>
    );

}

export default MovieScore;