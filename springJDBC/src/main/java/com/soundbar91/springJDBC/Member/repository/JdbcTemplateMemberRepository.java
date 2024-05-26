package com.soundbar91.springJDBC.Member.repository;

import com.soundbar91.springJDBC.Member.entity.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class JdbcTemplateMemberRepository implements MemberRepository {

    private final JdbcTemplate jdbcTemplate;
    private static final AtomicLong autoincrement = new AtomicLong(1);

    public JdbcTemplateMemberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Member> getMemberById(Long id) {
        String sql = "SELECT id, name, email, password FROM member WHERE id = ?";
        List<Member> result = jdbcTemplate.query(sql, memberRowMapper, id);
        return result.stream().findFirst();
    }

    @Override
    public void updateMember(Long id, Member member) {
        String sql = "UPDATE `member` SET name = ?, email = ?, password = ? WHERE id = ?";
        jdbcTemplate.update(sql, member.getName(), member.getEmail(), member.getPassword(), id);
    }

    @Override
    public boolean deleteMember(Long id) {
        String sql = "DELETE FROM `member` WHERE id = ?";
        return jdbcTemplate.update(sql, id) == 1;
    }

    @Override
    public void addMember(Member member) {
        String sql = "INSERT INTO MEMBER (id, name, email, password) VALUES (?, ?, ?, ?)";
        member.setId(autoincrement.getAndIncrement());
        jdbcTemplate.update(sql, member.getId(), member.getName(), member.getEmail(), member.getPassword());
    }

    private final RowMapper<Member> memberRowMapper = (resultSet, rowNum) -> {
        Member member = new Member(
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getString("password")
        );
        member.setId(resultSet.getLong("id"));
        return member;
    };
}
