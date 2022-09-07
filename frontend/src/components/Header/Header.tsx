import React from 'react'
import Icon from '../../assets/IconHeader.svg'
import style from './Header.module.css'

const Header = () => {
  return (
    <header>
      <div className={style.dsmeta_logo_container}>
        <img src={Icon} alt="DSMeta" />
        <h1>DSMeta</h1>
        <p>
          Desenvolvido por
          <a href="https://www.instagram.com/mateuscristofori/">
            @mateuscristofori
          </a>
        </p>
      </div>
    </header>
  )
}

export default Header
