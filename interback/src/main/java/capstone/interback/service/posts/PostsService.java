package capstone.interback.service.posts;

import capstone.interback.domain.Posts;
import capstone.interback.domain.PostsRepository;
import capstone.interback.web.dto.PostsResponseDto;
import capstone.interback.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 포스트가 없습니다. id = " + id));
        return new PostsResponseDto(entity);
    }
}
