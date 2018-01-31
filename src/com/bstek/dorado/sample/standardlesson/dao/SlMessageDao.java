package com.bstek.dorado.sample.standardlesson.dao;
import org.springframework.stereotype.Repository;
import com.bstek.dorado.hibernate.HibernateDao;
import com.bstek.dorado.sample.standardlesson.entity.SlMenu;
import com.bstek.dorado.sample.standardlesson.entity.SlMessage;
@Repository
public class SlMessageDao extends HibernateDao<SlMessage, Long> {
}
